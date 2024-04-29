import { createBrowserRouter, RouterProvider} from 'react-router-dom';
import { AppShell, Container, Text, Skeleton, Stack } from '@mantine/core';
import {LoginPage} from './pages/Login.page';
import { HomePage } from './pages/Home.page';
import { BookmarksPage } from './pages/Bookmarks.page';
import { TweetsLookupPage } from './pages/TweetsLookup.page';
import { RecentSearchPage } from './pages/RecentSearch.page';
import { AllDataSearchPage } from './pages/AllDataSearch.page';
import { PostTweetsSearchPage } from './pages/PostTweetsSearch.page';
import { TimelinePage } from './pages/Timeline.page';
import { AllDataPage } from './pages/AllData.page';
import { AuthSuccess } from './pages/AuthSuccess.page';
import { MePage } from './pages/me.page';
const router = createBrowserRouter([
    {
      path: '/',
     element: <HomePage />,
   },
   {
     path: '/login',
     element: <LoginPage />,
   },
   {
     path: '/bookmarks',
     element: <BookmarksPage />,
   },
   {
     path: '/lookup',
     element: <TweetsLookupPage />,
   },
   {
     path: '/recentsearch',
     element: <RecentSearchPage />,
   },
   {
     path: '/timeline',
     element: <TimelinePage />,
   },
   {
     path: '/searchAll',
     element: <AllDataSearchPage />,
   },
   {
     path: '/alldata',
     element: <AllDataPage />,
   },
   {
    path: '/searchPost',
    element: <PostTweetsSearchPage />,
   },
   {
     path: '/auth-success',
     element: <AuthSuccess />
   },
   {
    path: '/me',
    element: <MePage />
   }
 
]);

export function Router() {
  return <RouterProvider router={router} />;}


