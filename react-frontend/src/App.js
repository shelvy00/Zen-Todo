import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from "react-router-dom";
import HomePage from "./pages/HomePage";
import MainLayout from "./layouts/MainLayout";
import TaskPage from "./pages/TaskPage"
import AddTaskPage from "./pages/AddTaskPage";
import ProfilePage from "./pages/ProfilePage";
import EditTaskPage from "./pages/EditTaskPage";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<MainLayout />}>
      <Route index element={<HomePage />} />
      <Route path="/tasks" element={<TaskPage />} />
      <Route path="/add-tasks" element={<AddTaskPage />} />
      <Route path="/profile" element={<ProfilePage />} />
      <Route path="/edit-task" element={<EditTaskPage />} />
    </Route>
  )  
);

function App() {
  return <RouterProvider router={router} />
}

export default App;
