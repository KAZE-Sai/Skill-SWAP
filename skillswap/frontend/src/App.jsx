import React from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import Match from './pages/Match'

export default function App(){ return (<div><nav className='p-4 bg-gray-100'><Link to='/match'>Matches</Link></nav><Routes><Route path='/match' element={<Match/>} /></Routes></div>) }
