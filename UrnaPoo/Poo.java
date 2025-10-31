package UrnaPoo;

public class Poo {
    int votoSenador1, votoSenador2, votoPresidente;
    int votosNulos, votosBrancos, totalVotos;
    double porcentagemNulos, porcentagemBrancos;

    void votarNulo() {
        votosNulos++;
        totalVotos++;
    }

    void votarBranco() {
        votosBrancos++;
        totalVotos++;
    }

    void votarValido() {
        totalVotos++;
    }


    void calcularPorcentagens() {
        if (totalVotos > 0) {
            porcentagemNulos = (double) votosNulos / totalVotos * 100;
            porcentagemBrancos = (double) votosBrancos / totalVotos * 100;
        }
    }
}