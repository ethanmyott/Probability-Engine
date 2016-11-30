import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Engine {
	
	static BigInteger factorial(int n) {
		BigInteger result = BigInteger.valueOf(1);
		for(int i = n; i > 1; i--){
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
	
	static BigInteger nk(int n, int k){
		return (factorial(n).divide(factorial(k).multiply(factorial(n-k))));
	}
	
	//method E
	static BigInteger stirling(int x, int b){
		BigInteger summation = A(x, b);
		return summation.multiply(BigInteger.valueOf(1).divide(factorial(b)));
	}
	
	static BigInteger sequence(int b, int x){
		BigInteger i = BigInteger.valueOf(b);
		BigInteger B = BigInteger.valueOf(b);
		for(int n = x; n > 1; n--){
			i = i.multiply(B);
		}
		return i;
	}
	
	static BigInteger arrangement(int b, int x){
		return (factorial(b).divide(factorial(b-x)));
	}
	
	static BigInteger multisubset(int b, int x){
		return nk(x+b-1, x);
	}
	
	static BigInteger subset(int b, int x){
		return nk(b, x);
	}
	
	static BigInteger A(int x, int b) {
		BigInteger sum = BigInteger.valueOf(0);
		for(int k = 0; k <= b; k++){
			sum = sum.add(
			BigInteger.valueOf((long) Math.round(Math.pow(-1, k)))
			.multiply(nk(b, k)
			.multiply(sequence(b-k, x))));
		}
		return sum;
	}
	
	static BigInteger B(int b, int x){
		return nk(x-1, b-1);
	}
	
	static BigInteger C(int x, int b){
		BigInteger sum = BigInteger.valueOf(0);
		for(int k = 1; k <= b; k++){
			sum = sum.add(stirling(x, k));
		}
		return sum;
	}
	
	static BigInteger D(int x, int b){
		if(x <= b)
			return BigInteger.ONE;
		else return BigInteger.ZERO;
	}
	
	//Method H
	static BigInteger partition(int b, int x){
		return Partition.PbOfx(b, x);
	}
	
	//Principle of Inclusion-Exclusion
	//returns size of the union of multiple sets
	//positive test when used with integers and BigIntegers
	static <S> int PIE(S[][] sets) {
	     Set<S> set = new HashSet<S>();
	     for(S[] s : sets)
	     	set.addAll(Arrays.asList(s));
	     return set.toArray((S[]) new Object[0]).length;
	 }
}
