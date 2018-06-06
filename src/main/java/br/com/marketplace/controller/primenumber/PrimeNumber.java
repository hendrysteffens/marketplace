package br.com.marketplace.controller.primenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumber {

	public static void main(String[] args) {
		System.out.println(sieveOfEratosthenes(5002).stream().filter(n -> n >= 41 && n <= 5002).collect(Collectors.toList()));

	}

	/**
	 * Crivo_de_Eratóstenes.
	 */
	public static List<Integer> sieveOfEratosthenes(int finalNumber) {
		boolean prime[] = new boolean[finalNumber + 1];
		Arrays.fill(prime, true);
		for (int arrayPosition = 2; arrayPosition * arrayPosition <= finalNumber; arrayPosition++) {
			if (prime[arrayPosition]) {
				for (int i = arrayPosition * 2; i <= finalNumber; i += arrayPosition) {
					prime[i] = false;
				}
			}
		}
		List<Integer> primeNumbers = new ArrayList<>();
		for (int i = 2; i <= finalNumber; i++) {
			if (prime[i]) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}
}
