import React, {useEffect, useState} from 'react'
import TinderCard from 'react-tinder-card'
import axios from 'axios'

export default function Match(){
  const [profiles,setProfiles]=useState([])
  useEffect(()=>{ axios.get('http://localhost:8080/api/matches/candidates?me=1').then(r=>setProfiles(r.data)).catch(()=>{}) },[])
  return (<div className='p-6'><h2>Matches</h2>{profiles.map(p=> (<TinderCard key={p.id}><div className='p-4 bg-white shadow'>{p.fullName}</div></TinderCard>))}</div>)
}
