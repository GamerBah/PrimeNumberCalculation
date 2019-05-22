package me.gamerbah;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		System.out.print("Calculating starting number with 100 million digits");
		Thread loading = new Thread(() -> {
			int i = 0;
			while (!Thread.interrupted()) {
				try {
					Thread.sleep(650);
				} catch (InterruptedException e) {
					break;
				}
				i++;
				System.out.print("\rCalculating starting number with 100 million digits" + (i == 0 ? "" : i == 1 ? "." :
				                                                                                          i == 2 ? ".."
				                                                                                                 : "..."));
				if (i == 3) {
					i = -1;
				}
			}
		});
		loading.start();
		long       startTime = System.currentTimeMillis();
		BigInteger start     = new BigInteger("10").pow(99999999);
		loading.interrupt();
		System.out.print("\rCalculated starting number in " + Time
				.toString((System.currentTimeMillis() - startTime), true));

		System.out.print("\nWriting to file");
		loading = new Thread(() -> {
			int i = 0;
			while (!Thread.interrupted()) {
				try {
					Thread.sleep(650);
				} catch (InterruptedException e) {
					break;
				}
				i++;
				System.out.print("\rWriting to file" + (i == 0 ? "" : i == 1 ? "." : i == 2 ? ".." : "..."));
				if (i == 3) {
					i = -1;
				}
			}
		});
		loading.start();
		startTime = System.currentTimeMillis();
		saveToFile(start);
		loading.interrupt();
		System.out.print("\rDone! Took " + Time
				.toString((System.currentTimeMillis() - startTime), true) + " to write to \"out.txt\"");
	}

	public static void saveToFile(final BigInteger prime) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream("out.txt", false));
			out.print(prime);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
	}

}
