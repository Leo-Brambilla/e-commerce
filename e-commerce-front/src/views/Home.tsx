import { useFetch } from "../hooks/useFetch";
import { Typography, Card, CardActionArea, CardContent, CardMedia, CardActions, Button } from '@mui/material';
import { styled } from '@mui/system';
import { ProdutosModel } from "../models/ProdutosModel";

function formatCurrency(value: number): string {
    return value.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
}

const GridContainer = styled('div')({
    display: 'grid',
    gridTemplateColumns: 'repeat(1, minmax(0, 1fr))',
    gap: 4,
    maxWidth: '2xl',
    margin: '100px auto auto 100px',
    alignItems: 'center',
    justifyContent: 'center',
    
    '@media (min-width:600px)': {
        gridTemplateColumns: 'repeat(2, minmax(0, 1fr))',
    },
    '@media (min-width:900px)': {
        gridTemplateColumns: 'repeat(3, minmax(0, 1fr))',
    },
});

const StyledCard = styled(Card)({
    maxWidth: 450,
    margin:'30px'
});

export function Home() {
    const { data, error } = useFetch<ProdutosModel[]>('http://localhost:8080/produtos');

    if (error) {
        return <div>Ocorreu um erro: {error.message}</div>;
    }

    return (
        <GridContainer>
            {Array.isArray(data) && data?.map((item) => (
                <StyledCard key={item.nome}>
                    <CardActionArea>
                        <CardMedia
                            component="img"
                            alt={item.nome}
                            height={150}
                            width={150}
                            image={item.img}
                            title={item.nome}
                        />

                        <CardContent>
                            <Typography gutterBottom variant="h5" component="h2">
                                {item.nome}
                            </Typography>
                            <Typography variant="body2" color="textSecondary" component="p">
                                {item.descricao}
                            </Typography>
                            <Typography variant="h6" component="p">{formatCurrency(Number(item.valorVenda))}
                            </Typography>
                            <Typography variant="body2" color="textSecondary" component="p">
                                {item.quantidade} unidades disponíveis
                            </Typography>
                        </CardContent>
                    </CardActionArea>
                    <CardActions>
                        <Button size="small" color="primary">
                            Adicionar ao carrinho
                        </Button>
                    </CardActions>
                </StyledCard>
            ))}
        </GridContainer>
    );
};
