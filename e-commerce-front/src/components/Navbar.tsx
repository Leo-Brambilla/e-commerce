import { AppBar, Button, Toolbar, Typography } from '@mui/material';

export function Navbar() {
  return (
    <div className='bg-blue-950 fixed top-0 left-0 right-0 z-10'>
    <AppBar position="static">
      <Toolbar className='bg-zinc-600 text-orange-500'>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }} className='text-orange-500' >
          CodeWise
        </Typography>
        <Button color="inherit">Login</Button>
      </Toolbar>
    </AppBar>
    </div>
    
  );
}
