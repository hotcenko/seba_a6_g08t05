package tum.seba.mobilityservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tum.seba.mobilityservices.entity.Invoice;
import tum.seba.mobilityservices.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public void save(Invoice newInvoice) {
		invoiceRepository.save(newInvoice);
	}
	
	public Iterable<Invoice> findAll() {
		return invoiceRepository.findAll();
	}
	
	public Invoice findById(int invoiceId) {
		
		Optional<Invoice> foundInvoice = invoiceRepository.findById(invoiceId);
		
		if (foundInvoice.isPresent()) {
			return foundInvoice.get();
		} else {
			return null;
		}
		
	}
	
	public void deleteById(int invoiceId) {
		
		try {
			invoiceRepository.deleteById(invoiceId);
		}
		catch (Exception e) {
			System.err.println("Unable to delete Invoice with ID: " + invoiceId);
		}
		
	}

}
