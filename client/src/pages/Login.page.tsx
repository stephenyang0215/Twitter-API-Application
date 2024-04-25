import { Container, Button } from '@mantine/core';
import { useContext } from 'react';
import {AuthProvider, AuthContext, TAuthConfig} from 'react-oauth2-code-pkce';

// const authConfig: TAuthConfig = {
//     clientId: 'jjVe4U9zepo14wg53roxByNWN',
//     redirectUri: 'http://localhost:5173/',
//     // authorizationGrantType: 'authorization_code',
//     clientSecret: 'ouGm1QQJURV9zAOasltK0xifmYNYDkX6NANZ36sCJpqNDQAbaz',
//     authorizeUrl: 'https://twitter.com/i/oauth2/authorize?code_challenge=challenge&code_challenge_method=PLAIN',
//     tokenUrl: 'https://api.twitter.com/2/oauth2/token',
//     userInfoUrl: 'https://api.twitter.com/2/users/me',  
//     // scopes: {['tweet.read', 'tweet.write','user.read','offline.access']},

// }
// const Login =() => {
//     const {authorize} = useContext(AuthContext);
//     return (
//         <Button onClick={authorize}>Login with Twitter</Button>
//     );
// }

export const LoginPageComponent: React.FC = () => {

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
