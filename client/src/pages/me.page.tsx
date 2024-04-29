import { useEffect, useState } from 'react';

interface dataItem{
    data: User,
    error: string,
    includes: string
}
interface User {
    id: string,
     name: string,
      username: string
}


export function MePage() {
    const [userData, setUserData] = useState<User | null>(null);

   useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    const token = localStorage.getItem('accessToken');
  if (!token) {
    console.error('No access token found');
    return;
  }
    try {
      const response = await fetch(
        `http://localhost:8080/me?accessToken=${encodeURIComponent(token)}`); // Replace with your actual API endpoint
      const jsonData: dataItem = await response.json();
      console.log(jsonData);
      setUserData(jsonData.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };
 
  return (
    <>
    {userData ? (
        <div>
            <p>ID: {userData.id}</p>
            <p>Name: {userData.name}</p>
            <p>Username: {userData.username}</p>
        </div>
    ) : (
        <p>No user data available</p>
    )}
</>
  );    
}

