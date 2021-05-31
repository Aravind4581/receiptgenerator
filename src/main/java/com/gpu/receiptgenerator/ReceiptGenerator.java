package com.gpu.receiptgenerator;

import java.util.List;

import com.gpu.receiptgenerator.factory.ItemFactory;
import com.gpu.receiptgenerator.model.Item;
import com.gpu.receiptgenerator.model.Receipt;

public class ReceiptGenerator {
	
	
	Receipt generateReceipt(List<String>list) {
		
        List<Item> items = ItemFactory.from(list);
        return new Receipt(items);
    }
}
