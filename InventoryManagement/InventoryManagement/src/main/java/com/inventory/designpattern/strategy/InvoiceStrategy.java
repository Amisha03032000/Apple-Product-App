package com.inventory.designpattern.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.inventory.designpattern.facade.PDFGen;
import com.inventory.model.Invoice;
import com.inventory.model.PurchaseOrder;
import com.inventory.repository.InvoiceRepository;
import com.inventory.repository.OrderRepository;

public class InvoiceStrategy implements StrategyAPI{

	private InvoiceRepository invoiceRepo;
	private int id;
	private Invoice invoice;
	private OrderRepository orderRepo;
	
	public InvoiceStrategy(InvoiceRepository invoiceRepo, Invoice invoice) {
		super();
		this.invoiceRepo = invoiceRepo;
		this.invoice = invoice;
	}

	public InvoiceStrategy(InvoiceRepository invoiceRepo, int id , OrderRepository orderRepo) {
		this.invoiceRepo = invoiceRepo;
		this.id = id;
		this.orderRepo = orderRepo;
	}

	public InvoiceStrategy(InvoiceRepository invoiceRepo, int id) {
		super();
		this.invoiceRepo = invoiceRepo;
		this.id = id;
	}

	@Override
	public void add() {
		PurchaseOrder po = orderRepo.getPurchaseOrderbyID(id);
		po.setPaid(true);
		orderRepo.update(po);
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String paymentDate = formatter.format(date);
		
		Invoice invoice = new Invoice();
		invoice.setPaymentDate(paymentDate);
		invoice.setPurchaseOrder(po);
		int invoiceID = invoiceRepo.save(invoice);
		PDFGen.pdfGenerator(invoiceID, invoiceRepo);
	}

	@Override
	public void update() {
		invoiceRepo.update(invoice);
	}

	@Override
	public void delete() {
		Invoice invoice = invoiceRepo.getInvoicebyID(id);
		invoiceRepo.delete(invoice);
	}

}
