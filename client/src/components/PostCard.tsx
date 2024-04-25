import { Avatar, Card, Container, Text,Textarea, Group, Button, useMantineTheme, Grid, Stack, Flex} from '@mantine/core';
import {useState, useEffect} from 'react';

type PostCardProps = {
  
  onPost: (tweet: string) => void;
};



const PostCard : React.FC<PostCardProps>= ({onPost}) => {
  const theme = useMantineTheme();
  const [tweetText, setTweetText] = useState('');

const handleClickPost = async () => {
  onPost(tweetText);
  setTweetText('');
  
};


  return (
    <Card p="sm" radius='sm' mt={'10%'} withBorder style={{ width: '80%', height:'flex'}}>
      <Group align='flex-start'>
        <Avatar color='cyan' size={'md'} radius='xl'>SY</Avatar>
        <Textarea 
        placeholder="What's happening?" 
        style={{flexGrow:3}} 
        value={tweetText}
        onChange={(event) => setTweetText(event.currentTarget.value)}
        />
      </Group>
      <Group mt='sm' justify='flex-end'>
        <Button  
        color='blue' 
        radius='xl' 
        style={{ alignSelf: 'flex-end' }}
        onClick={handleClickPost}
        >Tweet !</Button>
      </Group>  
    </Card>
  );
};

export default PostCard;
