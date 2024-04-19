import { Container, Button } from '@mantine/core';

export const LoginPageComponent: React.FC = () => {
    const handleLogin = () => {
        // Handle login with Twitter here
    };

    return (
        <Container bg={'blue'}>
            <Container 
            style={{ display: 'grid', justifyContent: 'center', alignItems: 'center', height: '100%' }}
            
            >
                <h2>Login test</h2>
                <Button  
                style={{borderRadius: '10px', padding: '10px', backgroundColor:'lightblue', color: 'white'}}
                onClick={handleLogin} >
                Login with Twitter🐦
                </Button>
            </Container>
        </Container>
    );
};
