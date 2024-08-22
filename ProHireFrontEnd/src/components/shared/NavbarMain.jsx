import React from 'react'
import { Popover, PopoverContent, PopoverTrigger } from '@radix-ui/react-popover'
import {
    Avatar,
    AvatarFallback,
    AvatarImage,
} from "@/components/ui/avatar"
import { Button } from '../ui/button'
import { LogOut, User2 } from 'lucide-react'
import { Link } from 'react-router-dom'


function NavbarMain() {
    const user = false
    return (
        <div className='bg-sky-950 shadow-lg'>
            <div className='flex items-center justify-between mx-auto max-w-7xl h-16'>
            <div className="relative group">
          <h1 className="text-2xl font-bold text-white transition-transform duration-300 ease-in-out group-hover:translate-y-[-4px]">
            PRO<span className="text-[#F83002]">HIRE</span>
          </h1>
          <span className="absolute inset-0 opacity-0 group-hover:opacity-30 transition-opacity duration-300 ease-in-out"></span>
        </div>
                <div className='flex items-center gap-12'>
                    <ul className='flex font-medium items-center gap-5 text-white'>
                    <li className="relative group">
                        <Link
                          to="/"
                         className="hover:text-[#F83002] transition-colors duration-200"
                         >
                         Home
                        <span className="absolute left-0 bottom-[-3px] w-full h-[2px] bg-[#F83002] scale-x-0 group-hover:scale-x-100 transition-transform origin-left duration-300 ease-in-out"></span>
                        </Link>
                    </li>
                    <li className="relative group">
                        <Link
                          to="/"
                         className="hover:text-[#F83002] transition-colors duration-200"
                         >
                         browse
                        <span className="absolute left-0 bottom-[-3px] w-full h-[2px] bg-[#F83002] scale-x-0 group-hover:scale-x-100 transition-transform origin-left duration-300 ease-in-out"></span>
                        </Link>
                    </li>
                    <li className="relative group">
                        <Link
                          to="/browse"
                         className="hover:text-[#F83002] transition-colors duration-200"
                         >
                         Home
                        <span className="absolute left-0 bottom-[-3px] w-full h-[2px] bg-[#F83002] scale-x-0 group-hover:scale-x-100 transition-transform origin-left duration-300 ease-in-out"></span>
                        </Link>
                    </li>
                        {/* <li><Link to='/jobs'>Jobs</Link></li> */}
                        <li className="relative group">
                            <a  href="#about" className="hover:text-[#F83002] transition-colors duration-200 ">About 
                            <span className="absolute left-0 bottom-[-3px] w-full h-[2px] bg-[#F83002] scale-x-0 group-hover:scale-x-100 transition-transform origin-left duration-300 ease-in-out"></span>
                            </a></li>
                    </ul>
                    <div className='flex items-center gap-2'>
                        <Link to="/recruiter"><Button variant="outline" className="bg-[#d757cf] text-white hover:bg-[#db4ff7]">Recruiter</Button></Link>
                        <Link to="/jobseeker"><Button className="bg-[#7140c7] text-white hover:bg-[#8a46ff] ">Job Seeker</Button></Link>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default NavbarMain
