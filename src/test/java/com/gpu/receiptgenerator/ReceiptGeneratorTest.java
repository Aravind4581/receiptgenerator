package com.gpu.receiptgenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.gpu.receiptgenerator.model.Receipt;

public class ReceiptGeneratorTest {
	
	@Test
	public void test_generateReceipt_with_input1() throws IOException {
		
	File projectDir = new File(System.getProperty("user.dir"));	
	String fileName = projectDir+"/src/main/resources/input1.txt";
    Stream<String> lines = Files.lines(Paths.get(fileName));
    List<String>list= lines.collect(Collectors.toList());

	ReceiptGenerator receiptGenerator= new ReceiptGenerator();
	Receipt receipt = receiptGenerator.generateReceipt(list);
	System.out.print("Output 1: \n");
	System.out.print(receipt);
		
	}
	@Test
	public void test_generateReceipt_with_input2() throws IOException {
		
	File projectDir = new File(System.getProperty("user.dir"));	
	String fileName = projectDir+"/src/main/resources/input2.txt";
    Stream<String> lines = Files.lines(Paths.get(fileName));
    List<String>list= lines.collect(Collectors.toList());

	ReceiptGenerator receiptGenerator= new ReceiptGenerator();
	Receipt receipt = receiptGenerator.generateReceipt(list);
	System.out.print("\nOutput 2: \n");
	System.out.print(receipt);
		
	}
	
	@Test
	public void test_generateReceipt_with_input3() throws IOException {
		
	File projectDir = new File(System.getProperty("user.dir"));	
	String fileName = projectDir+"/src/main/resources/input3.txt";
    Stream<String> lines = Files.lines(Paths.get(fileName));
    List<String>list= lines.collect(Collectors.toList());

	ReceiptGenerator receiptGenerator= new ReceiptGenerator();
	Receipt receipt = receiptGenerator.generateReceipt(list);
	System.out.print("\nOutput 3: \n");
	System.out.print(receipt);
	}		
	

}
