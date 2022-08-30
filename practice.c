#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
 * Complete the 'getQueryResults' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. LONG_INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

/*
 * To return the integer array from the function, you should:
 *     - Store the size of the array to be returned in the result_count variable
 *     - Allocate the array statically or dynamically
 *
 * For example,
 * int* return_integer_array_using_static_allocation(int* result_count) {
 *     *result_count = 5;
 *
 *     static int a[5] = {1, 2, 3, 4, 5};
 *
 *     return a;
 * }
 *
 * int* return_integer_array_using_dynamic_allocation(int* result_count) {
 *     *result_count = 5;
 *
 *     int *a = malloc(5 * sizeof(int));
 *
 *     for (int i = 0; i < 5; i++) {
 *         *(a + i) = i + 1;
 *     }
 *
 *     return a;
 * }
 *
 */


int* getQueryResults(long n, int queries_rows, int queries_columns, int** queries, int* result_count) {
    int temp_r = *result_count;
    int *a = malloc(temp_r * sizeof(int));
    int *a_head = a;
    long t = 2;
    int good_array_cnt = 0;
    int good_array_sum = 0;

    for (int i = 0; i < *result_count; i++) {
        *(a + i) = i + 1;
    }

    int t_c = 0;
    for (int i = 0; i < *result_count; i++) {
        long i = queries[t_c][0];
        long r = queries[t_c][1];
        int m = queries[t_c][2];
        double result;

        t_c++;

        if (i == r) {
            result = fmod(pow(2, i), m);
        } else {
            result = fmod((pow(2, i) * pow(2, r)), m);
        }

        *a_head = result;
        a_head++;
    }
    
    return a;
}

int main(void) {
    long N;
    int q;
    int q_size;
    scanf("%ld", &N);
    scanf("%d", &q);
    scanf("%d", &q_size);

    int queries[q][q_size];
    for (int i = 0; i < q; i++) {
        for (int j = 0; j < q_size; j++) {
            int ab;
            if (j == q_size - 1) {
                scanf("%d", &ab);
            } else {
                scanf("%d ", &ab);
            }
            queries[i][j] = ab;
        } // seg fault from here after j == q_size - 1
        if (i == q - 1) break;
    } 

    int *aa = getQueryResults(N, q, q_size, &queries, &q);
    for (int i = 0; i < q; i++) {
        printf("%d\n", *aa);
        aa++;
    }
}