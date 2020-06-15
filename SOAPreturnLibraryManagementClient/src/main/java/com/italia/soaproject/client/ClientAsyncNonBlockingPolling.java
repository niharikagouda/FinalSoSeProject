package com.italia.soaproject.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import com.italia.soaproject.returnBook.BookReturnController;
import com.italia.soaproject.returnBook.BookReturnControllerImpl;
import com.italia.soaproject.returnBook.FindBook;

public class ClientAsyncNonBlockingPolling {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		BookReturnController service = new BookReturnControllerImpl();

		BookHandler handler = new BookHandler();

		System.out.println(formatter.format(new Date())
				+ " - invoking sendMessageWithReturnAsync(request, messageAsyncHandler) ...");

		Future<?> response = service.findBookWithReturnAsync("12qwesdfr", handler);

		while (!response.isDone()) {
			Thread.sleep(1000);
			System.out.println("waiting for response to come");
		}

		FindBook reply = handler.getResponse();
		System.out.println(
				formatter.format(new Date()) + " - service responded through callback with: " + reply.getName());
	}

}
