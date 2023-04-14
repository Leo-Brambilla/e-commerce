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
                    new Produtos(
                            "Smartphone Samsung Galaxy S21 Ultra 5G",
                            "O Galaxy S21 Ultra é o smartphone mais avançado da Samsung em 2021. Ele traz tela de 6,8 polegadas com resolução Quad HD+ e taxa de atualização de 120 Hz, processador Exynos 2100, 12 GB de RAM, armazenamento interno de 256 GB, bateria de 5.000 mAh e conjunto de quatro câmeras traseiras, com destaque para o sensor principal de 108 MP.",
                            new BigDecimal("6999.99"),
                            15,
                            "https://carrefourbr.vtexassets.com/arquivos/ids/15068485-540-auto?v=637521313266270000&width=540&height=auto&aspect=true"),
                    new Produtos("Notebook Dell Inspiron 15 5000", "O notebook Dell Inspiron 15 5000 é uma opção interessante para quem busca um modelo intermediário com bom custo-benefício. Ele traz tela de 15,6 polegadas com resolução Full HD, processador Intel Core i7 de 11ª geração, 8 GB de RAM, armazenamento interno de 256 GB em SSD e placa de vídeo dedicada Nvidia MX330 com 2 GB de memória GDDR5.", new BigDecimal("5199.99"),10,"https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/dell-client-products/notebooks/inspiron-notebooks/inspiron-15-3511/media-gallery/in3511nt_cnb_00000ff090_sl.psd?fmt=png-alpha&pscan=auto&scl=1&hei=402&wid=685&qlt=100,1&resMode=sharp2&size=685,402&chrss=full"),
                    new Produtos("Smart TV LG OLED 4K 65 polegadas", "A LG OLED CX é uma das melhores smart TVs de 2020, trazendo tela OLED de 65 polegadas com resolução 4K, suporte a HDR e Dolby Vision, processador Alpha 9 Gen 3, sistema operacional webOS 5.0, controle remoto com assistente virtual e suporte a HDMI 2.1 com taxa de atualização de 120 Hz.", new BigDecimal("12999.99"),5, "https://www.fastshop.com.br//wcsstore/FastShopCAS/images/catalog/LG65UQ8050PSB_PRD/LG65UQ8050PSB_PRD_447_1.jpeg"),
                    new Produtos("Câmera Sony Alpha A7 III", "A Sony Alpha A7 III é uma das câmeras mirrorless mais populares de 2021, trazendo sensor full-frame de 24,2 MP, sistema de autofoco híbrido com 693 pontos de detecção de fase e 425 pontos de contraste, estabilização de imagem de 5 eixos, disparo contínuo de até 10 fps e gravação de vídeo em 4K HDR.", new BigDecimal("10999.99"),7, "https://images.kabum.com.br/produtos/fotos/sync_mirakl/446436/Sony-Kit-Alpha-A7iii_1679316495_gg.jpg"),
                    new Produtos("Notebook Acer Aspire 5", "O notebook Acer Aspire 5 é uma boa opção para quem procura desempenho e portabilidade. Ele vem equipado com processador Intel Core i5 de 11ª geração, 8 GB de RAM, armazenamento em SSD de 512 GB, tela de 15,6 polegadas com resolução Full HD e placa de vídeo dedicada Nvidia GeForce MX350 com 2 GB de memória GDDR5.", new BigDecimal("4299.99"), 12, "https://images.kabum.com.br/produtos/fotos/sync_mirakl/308614/Notebook-Acer-Aspire-5-A514-54-52TY-Intel-Core-I5-11a-Gera-o-8GB-256GB-SSD-14-Full-HD-Windows-11-Home_1659442113_gg.jpg"),
                    new Produtos("Smartphone Xiaomi Mi 11 Lite", "O Xiaomi Mi 11 Lite é um smartphone intermediário com bom custo-benefício. Ele traz tela AMOLED de 6,55 polegadas com resolução Full HD+, processador Snapdragon 732G, 6 GB de RAM, armazenamento interno de 128 GB, bateria de 4.250 mAh e conjunto de câmeras traseiras triplas, com destaque para o sensor principal de 64 MP.", new BigDecimal("1899.99"), 20,"https://carrefourbr.vtexassets.com/arquivos/ids/94074070-540-auto?v=638086274656870000&width=540&height=auto&aspect=true"),
                    new Produtos("Tablet Apple iPad Pro", "O iPad Pro é um tablet premium da Apple com tela Liquid Retina XDR de 12,9 polegadas, processador M1, suporte a 5G, armazenamento interno de até 2 TB, sistema de câmera dupla com sensor principal de 12 MP e suporte a Apple Pencil de segunda geração e Magic Keyboard.", new BigDecimal("10999.99"), 5, "https://m.media-amazon.com/images/I/61PnHlc0HCL.__AC_SY445_SX342_QL70_ML2_.jpg"),
                    new Produtos("Smart TV Samsung QLED 8K 75 polegadas", "A smart TV Samsung QLED QN800A é uma das melhores TVs de 2021, trazendo tela de 75 polegadas com resolução 8K, suporte a HDR10+ e Dolby Vision, processador Neo Quantum, sistema operacional Tizen, controle remoto com assistente virtual e suporte a HDMI 2.1 com taxa de atualização de 120 Hz.", new BigDecimal("29999.99"), 3, "https://www.fastshop.com.br//wcsstore/FastShopCAS/imagens/_VD_Video/SGQN75Q950TS/SGQN75Q950TSv2_PRD_447_1.jpg"),
                    new Produtos("Caixa de som Bluetooth JBL Flip 5", "A caixa de som Bluetooth JBL Flip 5 é uma opção interessante para quem busca qualidade de som e portabilidade. Ela traz potência de 20 watts RMS, bateria de 4.800 mAh com autonomia de até 12 horas, resistência à água com certificação IPX7 e conexão com outros dispositivos JBL PartyBoost.", new BigDecimal("699.99"), 30, "https://images.kabum.com.br/produtos/fotos/sync_mirakl/122701/Caixa-de-Som-Port-til-JBL-Flip-5-C-Bluetooth-Prova-d-gua-2x-10W-Preto_1679406531_gg.jpg"),
                    new Produtos("Fone de ouvido sem fio Sony WH-1000XM4", "O fone de ouvido sem fio Sony WH-1000XM4 é um dos melhores modelos do mercado, trazendo cancelamento de ruído ativo, som de alta qualidade, autonomia de até 30 horas de bateria, controle por gestos e suporte a assistentes virtuais.", new BigDecimal("1999.99"), 8,"https://lojamultilaser.vteximg.com.br/arquivos/ids/247532-1000-1000/wh1000xm4bmuc_00.png?v=637750946878300000")

            );

            produtosRepository.saveAll(produtos);
        }
    }


