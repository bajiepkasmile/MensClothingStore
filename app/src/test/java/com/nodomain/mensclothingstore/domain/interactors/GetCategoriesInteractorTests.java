package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.CategoriesRemoteStorage;
import com.nodomain.mensclothingstore.domain.Error;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesSuccessEvent;
import com.nodomain.mensclothingstore.domain.exceptions.ConnectionFailedException;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import static junit.framework.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//TODO: reset
public class GetCategoriesInteractorTests {

    private Executor mockedExecutor = mock(Executor.class);
    private Handler mockedHandler = mock(Handler.class);
    private EventBus mockedEventBus = mock(EventBus.class);
    private CategoriesRemoteStorage mockedStorage = mock(CategoriesRemoteStorage.class);
    private NetworkUtil mockedNetworkUtil = mock(NetworkUtil.class);
    private GetCategoriesInteractor interactor;
    private ArgumentCaptor<OnGetCategoriesFailureEvent> failureEventCaptor =
            ArgumentCaptor.forClass(OnGetCategoriesFailureEvent.class);
    private ArgumentCaptor<OnGetCategoriesSuccessEvent> successEventCaptor =
            ArgumentCaptor.forClass(OnGetCategoriesSuccessEvent.class);

    @Before
    public void setUp() {
        interactor = new GetCategoriesInteractor(
                mockedExecutor,
                mockedHandler,
                mockedEventBus,
                mockedStorage,
                mockedNetworkUtil);

        doAnswer(invocation -> {
            Runnable runnable = (Runnable) invocation.getArguments()[0];
            runnable.run();
            return null;
        }).when(mockedExecutor).execute(any());

        when(mockedHandler.post(any())).then(invocation -> {
            Runnable runnable = (Runnable) invocation.getArguments()[0];
            runnable.run();
            return null;
        });
    }

    @Test
    public void postFailureEventWhenNetworkIsNotAvailable() {
        when(mockedNetworkUtil.networkIsAvailable()).thenReturn(false);

        interactor.execute();

        verify(mockedExecutor, times(0)).execute(any());
        verify(mockedHandler, times(0)).post(any());
        verify(mockedEventBus).postSticky(failureEventCaptor.capture());
        assertTrue(failureEventCaptor.getValue().getError() == Error.NETWORK_IS_NOT_AVAILABLE);
    }

    @Test
    public void postFailureEventWhenStorageThrowsException() {
        when(mockedNetworkUtil.networkIsAvailable()).thenReturn(true);
        when(mockedStorage.getCategories()).thenThrow(new ConnectionFailedException());

        interactor.execute();

        verify(mockedExecutor, times(1)).execute(any());
        verify(mockedHandler, times(1)).post(any());
        verify(mockedEventBus).postSticky(failureEventCaptor.capture());
        assertTrue(failureEventCaptor.getValue().getError() == Error.CONNECTION_FAILED);
    }

    @Test
    public void postSuccessEventWhenEverythingIsAllRight() {
        List<Category> categories = new ArrayList<>();
        when(mockedNetworkUtil.networkIsAvailable()).thenReturn(true);
        when(mockedStorage.getCategories()).thenReturn(categories);

        interactor.execute();

        verify(mockedExecutor, times(1)).execute(any());
        verify(mockedHandler, times(1)).post(any());
        verify(mockedEventBus).postSticky(successEventCaptor.capture());
        assertTrue(successEventCaptor.getValue().getCategories() == categories);
    }
}
