import HomeCard from '@/components/HomeCard';
import { Container, Button } from '@mantine/core';
import { useContext } from 'react';


export function LoginPage () {
    const handleClickLogin = async () => {
        const response = await fetch(
          `http://localhost:8080/login`,{
        
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
            // Include other headers as required
        },
        
        });
        if (response.ok) {
            const authUrl = await response.text();
            window.open(authUrl, '_blank');
          console.log('received auth url');
        } else {
          console.error('Failed to receive auth url');
        } 

      }
    return (
        <Container bg={'blue'}>
        <Container 
        style={{ display: 'grid', justifyContent: 'center', alignItems: 'center', height: '100%' }}
        
        >
            <h2>Login test</h2>
            <Button  
            style={{borderRadius: '10px', padding: '10px', backgroundColor:'lightblue', color: 'white'}}
            onClick={handleClickLogin} >
            Login with Twitter🐦
            </Button>
            
        </Container>
        
        
        
        
    </Container>
    )
   
   

}

