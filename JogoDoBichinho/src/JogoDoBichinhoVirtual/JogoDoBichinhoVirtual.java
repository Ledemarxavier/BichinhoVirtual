package JogoDoBichinhoVirtual;
import java.util.Scanner;

class BichinhoVirtual {
    public String nome;
    public String classe;
    public String familia;
    public int idade;
    public boolean vivo;
    public int caloria;
    public int forca;

    public BichinhoVirtual(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.forca = 10;
    }

    public void mostrarStatus() {
        System.out.println("\nNome: " + nome);
        System.out.println("Classe: " + classe);
        System.out.println("Família: " + familia);
        System.out.println("Idade: " + idade);
        System.out.println("Estado: " + (vivo ? "Vivo" : "Morto"));
        System.out.println("Calorias: " + caloria);
        System.out.println("Força: " + forca);
    }

    public void comer() {
        if (vivo && caloria < 100) {
            caloria = Math.min(caloria + 10, 100); // Limita caloria a 100
            forca = Math.max(forca - 2, 0); // Limita força a 0
            System.out.println(nome + " comeu! Calorias: " + caloria + ", Força: " + forca);
        } else {
            System.out.println(nome + " não pode comer.");
        }
    }

    public void correr() {
        if (vivo && caloria > 0 && forca > 0) {
            caloria = Math.max(caloria - 5, 0); // Limita caloria a 0
            forca = Math.max(forca - 5, 0); // Limita força a 0
            System.out.println(nome + " correu! Calorias: " + caloria + ", Força: " + forca);
        } else {
            System.out.println(nome + " está muito cansado para correr.");
        }
    }

    public void dormir() {
        if (vivo) {
            forca = Math.min(forca + 10, 100); // Limita força a 100
            caloria = Math.max(caloria - 2, 0); // Limita caloria a 0
            System.out.println(nome + " dormiu! Calorias: " + caloria + ", Força: " + forca);
        } else {
            System.out.println(nome + " não pode dormir.");
        }
    }

    public void morrer() {
        vivo = false;
        forca = 0;
        caloria = 0;
        System.out.println(nome + " morreu.");
    }

    public boolean isVivo() {
        return vivo;
    }
}

public class JogoDoBichinhoVirtual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Crie seu novo animal");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();
        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        BichinhoVirtual bichinho = new BichinhoVirtual(nome, classe, familia);
        System.out.println("\nSeu bichinho foi criado!");

        while (bichinho.isVivo()) {
            bichinho.mostrarStatus();
            System.out.println("\nO que " + nome + " vai fazer agora?");
            System.out.println("1 - Comer");
            System.out.println("2 - Correr");
            System.out.println("3 - Dormir");
            System.out.println("4 - Morrer");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> bichinho.comer();
                case 2 -> bichinho.correr();
                case 3 -> bichinho.dormir();
                case 4 -> bichinho.morrer();
                default -> System.out.println("Opção inválida.");
            }

        }


        System.out.println("GAME OVER!");
        scanner.close();
    }
}


