package com.te.gmail.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.gmail.bean.Gmail;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in); 
		
		System.out.println("WELCOME TO GMAIL");
		System.out.println("enter 1 for login   2 for registration");
		int choice= scanner.nextInt();
		switch (choice) {
		case 1:
			Login.login();
			break;
		case 2:
			Registration.register();
		default:
			System.out.println("invalid option");
			break;
		}
	}
}
