package com.itextpdf.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/***
 * java 导出PDF
 * @author xuhw
 * @date 2015-08-12:11:24
 * @description
 *
 */
public class ITextUtils {
	
	/**
	 * 创建一个Pdf文档
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public static void createPdf(String fileName) throws FileNotFoundException, DocumentException{
		//step 1:创建Document对象,默认是竖版，通过totate()设置为横版
		Document document=new Document(PageSize.A4.rotate());	
		//Document document=new Document(PageSize.A4,36,36,36,36);
		//step 2:获取PdfWriter实例
		PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(fileName));
		//(加密)setEncryption()：设置加密密码，是否可以拷贝打印等信息
		writer.setEncryption("hello".getBytes(), "world".getBytes(), PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
		//step 3:打开Document
		document.open();
		//step 4:添加内容
		document.add(new Paragraph("Hello World!"));
		document.addTitle("Hello World demo");
	    document.addAuthor("andy xu");
	    document.addSubject("This example explains how to add metadata.");
	    document.addKeywords("iText, Hello World, step 3, metadata");
	    document.addCreator("My first  iText document by java program language!");
		//step 5:关闭打开的Document
		document.close();		
	}
	
	public static void main(String[] args) throws Exception {
		String pdfPath="F://itext_hello01.pdf";
		createPdf(pdfPath);		
	}
}

