package Programmers_Copied;

public class Copied_Programmers_72413_FareForCarpooling {

	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

		System.out.println(solution(n, s, a, b, fares));

	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] node = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				node[i][j] = 20000001; // 200 * 100000 + 1
			}
			node[i][i] = 0;
		}

		// [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
		for (int i = 0; i < fares.length; i++) {
			node[fares[i][0]][fares[i][1]] = fares[i][2];
			node[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		// fares[i][0] -> 정점1
		// fares[i][1] -> 정점2
		// fares[i][2] -> 비용

		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (node[i][j] > node[i][k] + node[k][j]) { // 초기화된 값 > k를 거치는 값
						node[i][j] = node[i][k] + node[k][j];   // 초기화된 값 = k를 거치는 값
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < n + 1; i++) {
			min = Math.min(min, node[s][i] + node[i][a] + node[i][b]); // i -> 합승하는 위치
		}
		return min;
	}
}

// reference: https://moonsbeen.tistory.com/51
