import React from 'react'
import { Outlet } from 'react-router'
import Navb from '../components/Navb'

const MainLayout = () => {
  return (
   <>
   <Navb />
   <Outlet /> 
   </>
  )
}

export default MainLayout
