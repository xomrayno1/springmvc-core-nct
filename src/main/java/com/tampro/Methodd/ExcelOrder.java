package com.tampro.Methodd;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.tampro.Model.Bill;

public class ExcelOrder  extends AbstractXlsView{

	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 response.setHeader("Content-Disposition", "attachment;filename=\"order.xls\"");
		 @SuppressWarnings("unchecked")
		 List<Bill> listBill = (List<Bill>) model.get("listbill");
		 
		 Sheet sheet = workbook.createSheet("list order");
		 sheet.setDefaultColumnWidth(30);
		 //header row
		 Row header = sheet.createRow(0);
		 header.createCell(0).setCellValue("Id Bill");
		 header.createCell(1).setCellValue("id User");
		 header.createCell(2).setCellValue("Thoi Gian");
		 header.createCell(3).setCellValue("Tinh trang");
		 
		 int rowNum = 1;
		 for(Bill bill : listBill)
		 {
			 Row row = sheet.createRow(rowNum++);
			
			 row.createCell(0).setCellValue(bill.getIdBill());
			 row.createCell(1).setCellValue(bill.getIdUser());
			 row.createCell(2).setCellValue(bill.getDate());
			 row.createCell(3).setCellValue(bill.getStatus());
		
		 }
		 
		 
		 
	}

}
