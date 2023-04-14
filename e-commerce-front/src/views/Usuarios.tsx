import { Box, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography } from '@mui/material';
import { UsuarioModel } from '../models/UsuarioModel';
import { useFetch } from '../hooks/useFetch';

function formatDate(date: Date): string {
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const year = date.getFullYear().toString();
    return `${day}/${month}/${year}`;
}

export function Usuarios() {
    const { data, error } = useFetch<UsuarioModel[]>('http://localhost:8080/usuarios');

    if (error) {
        return <div>Ocorreu um erro: {error.message}</div>;
    }

    return (
        <div className='bg-zinc-900 mx-auto'>

            <div>
                <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh',maxHeight:'100vh', maxWidth: '100%', width: '97.9vw', margin: '0 20px 0 20px' }}>
                    <TableContainer component={Paper} sx={{ overflowX: 'auto' }}>
                        <Typography variant="h4" sx={{ textAlign: 'center', mb: 2, backgroundColor:'rgb(82, 82, 91)', color:'#FFFFFF' }}>Usuários</Typography>
                        <Table aria-label="simple table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Nome</TableCell>
                                    <TableCell align="center">E-mail</TableCell>
                                    <TableCell align="center">Data de Criação</TableCell>
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
                                        <TableCell align="center">{row.email}</TableCell>
                                        <TableCell align="center">{formatDate(new Date(row.dataCriacao))}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Box>
            </div>
        </div>

    );
}
