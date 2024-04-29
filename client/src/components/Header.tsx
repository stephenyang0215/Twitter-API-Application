
import { Container, Text} from '@mantine/core';
export function Header(){
    return(
         
    <Container    
    bg={'var(--mantine-color-blue-light)'} style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100%' }}>
    <Text style={{ color: 'white', fontWeight: 1000 }}>Twitter Fetch</Text>
    
    </Container>
    )
}
