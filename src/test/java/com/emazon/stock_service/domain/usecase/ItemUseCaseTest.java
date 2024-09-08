package com.emazon.stock_service.domain.usecase;

import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.domain.spi.IItemPersistentPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemUseCaseTest {
    private final IItemPersistentPort itemPersistentPortMock = mock(IItemPersistentPort.class, "itemPersistentPort");

    @Test
    void saveItem() {
        Item item = mock(Item.class);
        doNothing().when(itemPersistentPortMock).saveItem(item);
        ItemUseCase useCase = new ItemUseCase(itemPersistentPortMock);
        useCase.saveItem(item);

        assertAll("Result", () -> verify(itemPersistentPortMock).saveItem(item));
    }
}