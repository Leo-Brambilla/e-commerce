import { useFetch } from "../hooks/useFetch";
import { Box, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography } from '@mui/material';
import { ProdutosModel } from "../models/ProdutosModel";

function formatCurrency(value: number): string {
  return value.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
}

export function Produtos() {
    const { data, error } = useFetch<ProdutosModel[]>('http://localhost:8080/produtos');

    if (error) {
        return <div>Ocorreu um erro: {error.message}</div>;
    }

    return (
        <div className='bg-zinc-900 mx-auto'>
            <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh', maxHeight: '100vh', maxWidth: '100%', width: '97.9vw', margin: '0 20px 0 20px' }}>
                <TableContainer component={Paper} sx={{ overflowX: 'auto' }}>
                    <Typography variant="h4" sx={{ textAlign: 'center', mb: 2, backgroundColor: 'rgb(82, 82, 91)', color: '#FFFFFF' }}>Clientes</Typography>
                    <Table aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell align="center">Imagem</TableCell>
                                <TableCell align="center">Nome</TableCell>
                                <TableCell align="center">Descrição</TableCell>
                                <TableCell align="center">Valor</TableCell>
                                <TableCell align="center">Quantidade em Estoque</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {data?.map((row) => (
                                <TableRow key={row.nome} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                                    <TableCell component="th" scope="row">{row.img}</TableCell>
                                    <TableCell align="center">{row.nome}</TableCell>
                                    <TableCell align="center">{row.descricao}</TableCell>
                                    <TableCell align="center">{formatCurrency(Number(row.valorVenda))}</TableCell>
                                    <TableCell align="center">{row.quantidade}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </Box>
        </div>
    );
}