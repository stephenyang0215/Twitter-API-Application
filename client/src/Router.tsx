import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import {LoginPageComponent} from './pages/Login.page';
import { HomePage } from './pages/Home.page';
import { BookmarksPage } from './pages/Bookmarks.page';
import { TweetsLookupPage } from './pages/TweetsLookup.page';
import { RecentSearchPage } from './pages/RecentSearch.page';
const router = createBrowserRouter([
  {
    path: '/login',
    element: <LoginPageComponent />,
  },
  {
    path: '/',
    element: <HomePage />,
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
  }
  
]);

export function Router() {
  return <RouterProvider router={router} />;
}
