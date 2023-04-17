 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 05/04/2023
  * 
  * @Description : BookNOTFOund Class is for handling Book not found exceptions when dealing with database.
  * ==========================
  * */
package com.hfdc.lms.exception;

public class BookNotFound extends Exception {

	public BookNotFound(String message) {
		super(message);
		
	}

}
