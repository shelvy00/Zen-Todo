import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from "react-router-dom";
import HomePage from "./pages/HomePage";
import MainLayout from "./layouts/MainLayout";
import TaskPage from "./pages/TaskPage"
import AddTaskPage from "./pages/AddTaskPage";
import ProfilePage from "./pages/ProfilePage";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<MainLayout />}>
      <Route index element={<HomePage />} />
      <Route path="/tasks" element={<TaskPage />} />
      <Route path="/add-tasks" element={<AddTaskPage />} />
      <Route path="/profile" element={<ProfilePage />} />
    </Route>
  )  
);

function App() {
  return <RouterProvider router={router} />
}

export default App;
