package com.gpu.receiptgenerator.factory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.gpu.receiptgenerator.model.Item;
import com.gpu.receiptgenerator.taxevaluator.TaxEvaluator;

public class ItemFactory {
	private static final String REGEX_PATTERN = "(\\d+) ([\\w\\s]* )at (\\d+.\\d{2})";

	public static Item createItemFromString(String input) {
		Pattern pattern = Pattern.compile(REGEX_PATTERN);
		Matcher matcher = pattern.matcher(input);
		matcher.find();
		
		return new Item(matcher.group(1), matcher.group(2), matcher.group(3));
	}
	
    public static List<Item> from(List<String> lines) {
        return lines.stream().map(ItemFactory::from)
                .collect(Collectors.toList());
    }

    private static Item from(String input) {
        Item item = createItemFromString(input);
        TaxEvaluator.applyTaxes(item);
        return item;
    }

    
    
}
