public class RemoveElement {

	public static void main(String[] args) {
		int[] A = { 3 };
		System.out.println("return value: " + removeElementBettina(A, 3));
		for (int i = 0; i < A.length; i++) {
			System.out.println("A[" + i + "]: " + A[i]);
		}

	}

	public static int removeElement(int[] A, int elem) {
		int newLength = A.length;

		int i = 0;
		while (i < newLength) {
			if (A[i] == elem) {
				swapElement(A, i, newLength - 1);
				newLength--;
			} else {
				i++;
			}
		}
		return newLength;
	}

	public static int removeElementBettina(int[] A, int elem) {
		int frontIdx = 0;
		if (A == null || A.length == 0)
			return 0;
		int endIdx = A.length - 1;
		while (endIdx >= 0 && A[endIdx] == elem) {
			endIdx--;
		}

		while (frontIdx != endIdx && frontIdx < endIdx && endIdx > 0) {
			if (A[frontIdx] == elem) {
				A[frontIdx] = A[endIdx];
				A[endIdx] = elem;
				while (endIdx >= 0 && A[endIdx] == elem)
					endIdx--;
			}
			frontIdx++;

		}
		return endIdx;
	}

	public static void swapElement(int[] A, int index1, int index2) {
		int tmp = A[index1];
		A[index1] = A[index2];
		A[index2] = tmp;
	}
}
