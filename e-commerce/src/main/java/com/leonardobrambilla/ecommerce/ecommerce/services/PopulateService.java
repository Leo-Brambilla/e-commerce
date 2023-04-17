package com.leonardobrambilla.ecommerce.ecommerce.services;


import com.leonardobrambilla.ecommerce.ecommerce.domain.Clientes;
import com.leonardobrambilla.ecommerce.ecommerce.domain.Produtos;
import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.ClientesRepository;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.ProdutosRepository;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

@Service
public class PopulateService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClientesRepository clienteRepository;
    @Autowired
    private ProdutosRepository produtosRepository;
        public void populate() {
            // Criar usuários fictícios
            List<Usuario> usuarios = Arrays.asList(
                    new Usuario(null, "Fulano da Silva", "fulano@email.com", "123456",
                            LocalDate.of(2022, 1, 1)),
                    new Usuario(null, "Ciclano Souza", "ciclano@email.com", "123456",
                            LocalDate.of(2022, 2, 1)),
                    new Usuario(null, "Beltrano Santos", "beltrano@email.com", "123456",
                            LocalDate.of(2022, 3, 1)),
                    new Usuario(null, "José Pereira", "jose@email.com", "123456",
                            LocalDate.of(2022, 4, 1)),
                    new Usuario(null, "Maria Oliveira", "maria@email.com", "123456",
                            LocalDate.of(2022, 5, 1)),
                    new Usuario(null, "Pedro Rocha", "pedro@email.com", "123456",
                            LocalDate.of(2022, 6, 1)),
                    new Usuario(null, "Joana Ferreira", "joana@email.com", "123456",
                            LocalDate.of(2022, 7, 1)),
                    new Usuario(null, "Roberto Alves", "roberto@email.com", "123456",
                            LocalDate.of(2022, 8, 1)),
                    new Usuario(null, "Luciana Costa", "luciana@email.com", "123456",
                            LocalDate.of(2022, 9, 1)),
                    new Usuario(null, "Rafaela Santos", "rafaela@email.com", "123456",
                            LocalDate.of(2022, 10, 1))
            );
            usuarioRepository.saveAll(usuarios);

            List<Clientes> clientes = Arrays.asList(
                    new Clientes("Ana", "Silva", "F", LocalDate.parse("1985-01-01"), "Brasileira", "Rua A, 123", "São Paulo", "SP", "1199999999", "ana.silva@email.com", "senha123"),
                    new Clientes("João", "Santos", "M", LocalDate.parse("1990-05-10"), "Brasileiro", "Rua B, 456", "Rio de Janeiro", "RJ", "2198888888", "joao.santos@email.com", "senha123"),
                    new Clientes("Pedro", "Ferreira", "M", LocalDate.parse("1988-03-15"), "Português", "Rua C, 789", "Lisboa", "Lisboa", "+351912345678", "pedro.ferreira@email.com", "senha123"),
                    new Clientes("Mariana", "Oliveira", "F", LocalDate.parse("1995-11-22"), "Brasileira", "Rua D, 456", "Salvador", "BA", "7197777777", "mariana.oliveira@email.com", "senha123"),
                    new Clientes("Bruno", "Souza", "M", LocalDate.parse("1992-07-17"), "Brasileiro", "Rua E, 654", "Curitiba", "PR", "4196666666", "bruno.souza@email.com", "senha123"),
                    new Clientes("Fernanda", "Ribeiro", "F", LocalDate.parse("1986-09-08"), "Brasileira", "Rua F, 987", "Belo Horizonte", "MG", "3195555555", "fernanda.ribeiro@email.com", "senha123"),
                    new Clientes("Paulo", "Silveira", "M", LocalDate.parse("1979-12-25"), "Brasileiro", "Rua G, 321", "Porto Alegre", "RS", "5194444444", "paulo.silveira@email.com", "senha123"),
                    new Clientes("Amanda", "Santana", "F", LocalDate.parse("1998-06-02"), "Brasileira", "Rua H, 654", "Fortaleza", "CE", "8593333333", "amanda.santana@email.com", "senha123"),
                    new Clientes("Lucas", "Costa", "M", LocalDate.parse("1993-04-11"), "Brasileiro", "Rua I, 321", "Recife", "PE", "8192222222", "lucas.costa@email.com", "senha123"),
                    new Clientes("Mariza", "Lima", "F", LocalDate.parse("2000-07-17"), "Brasileira", "Rua Fui, 322", "Recife", "PE", "8191222222", "marili@email.com", "senha123")
            );

            clienteRepository.saveAll(clientes);

            List<Produtos> produtos = Arrays.asList(

                    new Produtos("Smart TV LG OLED 4K 65 polegadas", "A LG OLED CX é uma das melhores smart TVs de 2020, trazendo tela OLED de 65 polegadas com resolução 4K, suporte a HDR e Dolby Vision, processador Alpha 9 Gen 3, sistema operacional webOS 5.0, controle remoto com assistente virtual e suporte a HDMI 2.1 com taxa de atualização de 120 Hz.", new BigDecimal("12999.99"),5, "https://m.media-amazon.com/images/I/61Q3cFuEUvL._AC_SX522_.jpg"),
                    new Produtos("Smart TV Samsung QLED 8K 75 polegadas", "A smart TV Samsung QLED é uma das melhores TVs de 2021, trazendo tela de 75 polegadas com resolução 8K, suporte a HDR10+ e Dolby Vision, processador Neo Quantum, sistema operacional Tizen, controle remoto com assistente virtual e suporte a HDMI 2.1 com taxa de atualização de 120 Hz.", new BigDecimal("29999.99"), 3, "https://m.media-amazon.com/images/I/61Jr5SHKuiL._AC_SX522_.jpg"),
                    new Produtos("Smart TV LED 43 polegadas FULL HD TCL 43S615 - Android TV, HDMI", "A Smart TV TCL de 43 polegadas é uma excelente escolha para quem busca qualidade e conveniência. Com tela Full HD e tecnologia LED, oferece imagens nítidas e vibrantes. A TV é uma Android TV, o que permite acesso a diversos aplicativos, com entrada HDMI para conexão de dispositivos.", new BigDecimal("1636.87"), 3, "https://m.media-amazon.com/images/I/81H31rbyGcL._AC_SX522_.jpg"),

                    new Produtos("Notebook Dell Inspiron 15 5000", "O notebook Dell Inspiron 15 5000 é uma opção interessante para quem busca um modelo intermediário com bom custo-benefício. Ele traz tela de 15,6 polegadas com resolução Full HD, processador Intel Core i7 de 11ª geração, 8 GB de RAM, armazenamento interno de 256 GB em SSD e placa de vídeo dedicada Nvidia MX330 com 2 GB de memória GDDR5.", new BigDecimal("5199.99"),10,"https://m.media-amazon.com/images/I/71viEv5y8aL._AC_SX679_.jpg"),
                    new Produtos("Notebook Acer Aspire 5", "O notebook Acer Aspire 5 é uma boa opção para quem procura desempenho e portabilidade com um valor acessível. Ele vem equipado com processador Intel Core i5 de 11ª geração, 8 GB de RAM, armazenamento em SSD de 512 GB, tela de 15,6 polegadas com resolução Full HD e placa de vídeo dedicada Nvidia GeForce MX350 com 2 GB de memória GDDR5.", new BigDecimal("4299.99"), 12, "https://m.media-amazon.com/images/I/51E+Wzu+6EL._AC_UL400_.jpg"),
                    new Produtos("Notebook Apple MacBook Pro", "O MacBook Pro tem tela de 16\", processadores M1 Pro/Max com CPU até 10-core e GPU até 32-core, Neural Engine 16-core para aprendizagem automática 5x mais rápida, bateria de 21h e vem com Cabo USB-C para MagSafe 3 e Adaptador de corrente USB-C de 140W. É um notebook de última geração com tecnologia de ponta.", new BigDecimal("22299.99"), 7, "https://m.media-amazon.com/images/I/61Y30DpqRVL._AC_SX679_.jpg"),

                    new Produtos("Smartphone Xiaomi Mi 11 Lite", "O Xiaomi Mi 11 Lite é um smartphone intermediário com bom custo-benefício. Ele traz tela AMOLED de 6,55 polegadas com resolução Full HD+, processador Snapdragon 732G, 6 GB de RAM, armazenamento interno de 128 GB, bateria de 4.250 mAh e conjunto de câmeras traseiras triplas, com destaque para o sensor principal de 64 MP.", new BigDecimal("1899.99"), 20,"https://m.media-amazon.com/images/I/61YI0NUDaWS._AC_SX522_.jpg"),
                    new Produtos("Smartphone Samsung Galaxy S23 Ultra 5G","Samsung Galaxy S23 Ultra: tela de 6,8 polegadas, processador Exynos 2100, 12 GB de RAM, armazenamento interno de 256 GB, bateria de 5.000 mAh e conjunto de quatro câmeras traseiras, com sensor principal de 108 MP.",new BigDecimal("6999.99"),15,"https://m.media-amazon.com/images/I/61KjRETZLKL.__AC_SY300_SX300_QL70_ML2_.jpg"),
                    new Produtos("Smartphone Apple iPhone 14 Pro Max (128 GB)","O iPhone 14 Pro Max tem tela Super Retina XDR de 6,7 com tela Sempre Ativa e ProMotion, câmera grande-angular de 48 MP com Cinema em 4K Dolby Vision. Possui Detecção de Acidente, bateria que dura o dia todo e Dynamic Island.",new BigDecimal("8876.67"),5,"https://m.media-amazon.com/images/I/51iJx7YWDOL._AC_UL400_.jpg"),

                    new Produtos("Tablet Apple iPad Pro", "O iPad Pro é um tablet premium da Apple com tela Liquid Retina XDR de 12,9 polegadas, processador M1, suporte a 5G, armazenamento interno de até 2 TB, sistema de câmera dupla com sensor principal de 12 MP e suporte a Apple Pencil de segunda geração e Magic Keyboard.", new BigDecimal("10999.99"), 5, "https://m.media-amazon.com/images/I/41GpW++wNuL._AC_UL400_.jpg"),
                    new Produtos("Tablet Tablet Pad 5Pro", "O tablet Pad 5 Pro tem tela de 11 polegadas, estrutura de metal resistente, Snapdragon 888 Octa-Core + 8GB de RAM + 256GB de armazenamento interno (expansível com microSD 128GB), bateria de 8800mAh com carga rápida, câmera frontal de 16MP e traseira de 32MP.", new BigDecimal("699.99"), 5, "https://m.media-amazon.com/images/I/51caoaWBrsL._AC_SX679_.jpg"),
                    new Produtos("Tablet Samsung Galaxy S6 Lite", "O Tablet Samsung Galaxy S6 Lite possui 128GB de armazenamento interno e 4GB de RAM para rodar múltiplos aplicativos simultaneamente. Tela de 10.4 polegadas com resolução de 2000x1200 pixels, câmera traseira de 8MP e frontal de 5MP, e bateria de 7,040mAh.", new BigDecimal("2599.99"), 12, "https://m.media-amazon.com/images/I/61KIendhj0S._AC_SX679_.jpg")


            );

            produtosRepository.saveAll(produtos);
        }
    }


