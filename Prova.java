
public class Prova {
    public static void main(String[] args) {
        // 1 - esse método inverte os as posições, inverte o vetor, de e até d, por isso
        // a verificação de e>=d,
        // para ele parar, é o caso base
        // int[] v = { 10, 56, 78, 42, 12, 36 };
        // int e = 0;
        // int d = 5;
        // metodoRec02(v, e, d);
        // for (int i : v) {
        // System.out.println(i);
        // }

        // Tribonacci

        // imprimirTribonacci(10);

        // Pell

        // imprimirPell(5);

        // Sentença dançante

        // String x = " THis is a Dancing sentence aaaaaaaaaaa z";
        // System.out.println(sentencaDançante(x));

        // Jedi

        int numCand = 5;
        int numAprov = 2;
        int[] vet = { 1, 5, 2, 4, 3 };
        System.out.println(somarForca(numAprov, numCand, vet));
    }

    public static int somarForca(int numAprov, int numCand, int[] vet) {
        int forca = 0;

        vet = mergeSort(0, vet.length, vet);

        for (int i = 0; i < numAprov; i++) {
            forca += vet[i];
        }
        return forca;
    }

    public static String sentencaDançante(String x) {
        String fim = "";
        boolean upper = true;

        x = x.toLowerCase();
        char[] vet = x.toCharArray();

        for (int i = 0; i < vet.length; i++) {
            if (vet[i] != ' ') {

                if (upper) {
                    vet[i] = (char) (vet[i] - 32);
                    upper = false;
                } else {
                    upper = true;
                }

            }
            fim += vet[i];
        }

        return fim;
    }

    public static void imprimirASCII() {
        for (int i = 0; i < 255; i++) {
            System.out.println(i + " = " + (char) i);
        }
    }

    public static void imprimirPell(int i) {
        if (i >= 0) {
            imprimirPell(i - 1);
            System.out.print(pell(i) + " ");
        }
    }

    public static int pell(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return 2 * pell(num - 1) + pell(num - 2);
        }
    }

    public static void metodoRec02(int v[], int e, int d) {
        int t;
        if (e >= d)
            return;
        else {
            t = v[e];
            v[e] = v[d];
            v[d] = t;
            metodoRec02(v, e + 1, d - 1);
        }
    }

    public static void imprimirTribonacci(int i) {
        if (i >= 0) {
            imprimirTribonacci(i - 1);
            System.out.print(tribonacci(i) + " ");
        }
    }

    public static int tribonacci(int num) {
        if (num == 0 || num == 1) {
            return 0;
        } else if (num == 2) {
            return 1;
        } else {
            return tribonacci(num - 1) + tribonacci(num - 2) + tribonacci(num - 3);
        }
    }

    public static int[] mergeSort(int inicio, int fim, int[] vet) {
        if (inicio < fim - 1) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio, vet);
            mergeSort(meio, fim, vet);
            doMerge(vet, inicio, meio, fim);
        }
        return vet;
    }

    public static void doMerge(int[] vet, int inicio, int meio, int fim) {
        int i = inicio;
        int m = meio;
        int k = 0;
        int[] vetAux = new int[fim - inicio];

        while (i < meio && m < fim) {
            if (vet[i] >= vet[m]) {
                vetAux[k++] = vet[i++];
            } else {
                vetAux[k++] = vet[m++];
            }
        }

        while (i < meio) {
            vetAux[k++] = vet[i++];
        }

        while (m < fim) {
            vetAux[k++] = vet[m++];
        }

        for (int j = inicio; j < fim; j++) {
            vet[j] = vetAux[j - inicio];
        }
    }
}
