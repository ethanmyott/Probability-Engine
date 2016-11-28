import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Partition {

	static BigInteger PbOfx(int b, int x){
		List<BigInteger[]> partitions = partition(x);
		BigInteger count = BigInteger.ZERO;
		for(BigInteger[] partition : partitions){
			if(partition.length == b)
				count = count.add(BigInteger.valueOf(1));
		}
		return count;
	}
	
    /**
     * partition returns a list of int[] that represent all distinct partitions of n.
     */
    private static List<BigInteger[]> partition(int n) {
        List<BigInteger> partial = new ArrayList<BigInteger>();
        List<BigInteger[]> partitions = new ArrayList<BigInteger[]>();
        partition(n, partial, partitions);
        return partitions;
    }

    /**
     * If n=0, it copies the partial solution into the list of complete solutions.
     * Else, for all values i less than or equal to n, put i in the partial solution and partition the remainder n-i.
     */
    private static void partition(int n, List<BigInteger> partial, List<BigInteger[]> partitions) {
        //System.out.println("partition " + n + ", partial solution: " + partial);
        if (n == 0) {
            // Complete solution is held in 'partial' --> add it to list of solutions
            partitions.add(toArray(partial));
        } else {
            // Iterate through all numbers i less than n.
            // Avoid duplicate solutions by ensuring that the partial array is always non-increasing
            for (int i=n; i>0; i--) {
            	if(partial.isEmpty()){
            		partial.add(BigInteger.valueOf(i));
                    partition(n-i, partial, partitions);
                    partial.remove(partial.size()-1);
            	}
            	else {
            		int c = partial.get(partial.size()-1).compareTo(BigInteger.valueOf(i));
            		if(c == 1 || c==0)
            		{
            			partial.add(BigInteger.valueOf(i));
                        partition(n-i, partial, partitions);
                        partial.remove(partial.size()-1);
            		}
            	}
            }
        }
    }

    /**
     * Helper method: creates a new integer array and copies the contents of the list into the array.
     */
    private static BigInteger[] toArray(List<BigInteger> list) {
        BigInteger[] arr = new BigInteger[list.size()];
        return list.toArray(arr);
    }
    
    private static String print(BigInteger[] b){
    	String out = "{";
    	int i = 0;
    	for(BigInteger bi : b){
    		out += Integer.toString(bi.intValueExact());
    		if(i != b.length - 1)
    			out += ", ";
    		i++;
    	}
    	out += "}";
    	return out;
    }
}