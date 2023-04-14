import { useFetch } from "../hooks/useFetch";
import { ClientesModel } from "../models/ClientesModel";
import { Box, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography } from '@mui/material';

function formatDate(date: Date): string {
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const year = date.getFullYear().toString();
    return `${day}/${month}/${year}`;
}

export function Clientes() {
    const { data, error } = useFetch<ClientesModel[]>('http://localhost:8080/clientes');

    if (error) {
        return <div>Ocorreu um erro: {error.message}</div>;
    }

    return (
        <div className='bg-zinc-900 mx-auto'>

            <div>
                <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh', maxHeight: '100vh', maxWidth: '100%', width: '97.9vw', margin: '0 20px 0 20px' }}>
                    <TableContainer component={Paper} sx={{ overflowX: 'auto' }}>
                        <Typography variant="h4" sx={{ textAlign: 'center', mb: 2, backgroundColor: 'rgb(82, 82, 91)', color: '#FFFFFF' }}>Clientes</Typography>
                        <Table aria-label="simple table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Nome</TableCell>
                                    <TableCell align="center">Sobrenome</TableCell>
                                    <TableCell align="center">Sexo</TableCell>
                                    <TableCell align="center">Data de Nascimento</TableCell>
                                    <TableCell align="center">Nacionalidade</TableCell>
                                    <TableCell align="center">Endereço</TableCell>
                                    <TableCell align="center">Cidade</TableCell>
                                    <TableCell align="center">Estado</TableCell>
                                    <TableCell align="center">Telefone</TableCell>
                                    <TableCell align="center">E-mail</TableCell>

                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {data?.map((row) => (
                                    <TableRow
                                        key={row.nome}
                                        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                    >
                                        <TableCell component="th" scope="row">
                                            {row.nome}
                                        </TableCell>
                                        <TableCell align="center">{row.sobrenome}</TableCell>
                                        <TableCell align="center">{row.sexo}</TableCell>
                                        <TableCell align="center">{formatDate(new Date(row.dataNascimento))}</TableCell>
                                        <TableCell align="center">{row.nacionalidade}</TableCell>
                                        <TableCell align="center">{row.endereco}</TableCell>
                                        <TableCell align="center">{row.cidade}</TableCell>
                                        <TableCell align="center">{row.estado}</TableCell>
                                        <TableCell align="center">{row.telefone}</TableCell>
                                        <TableCell align="center">{row.email}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Box>
            </div>
        </div>

    )
}