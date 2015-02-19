package com.demo;

import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@ViewScoped
public class FileDownloadController {
	private StreamedContent file;

	public FileDownloadController() {
		try {
			InputStream stream = this.getClass().getResourceAsStream("/users.pdf");
			System.out.println("stream: "+stream);
			file = new DefaultStreamedContent(stream, "application/pdf", "downloaded_file.pdf");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Downloaded"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StreamedContent getFile() {
		return this.file;
	}
	
	public void showStatus(){
		System.out.println("---showStatus---");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Downloaded..."));
		//FacesContext.getCurrentInstance().getExternalContext().getFlash().put("msg", "Downloaded..");
		//return "index.jsf?faces-redirect=true";
		
	}
}
