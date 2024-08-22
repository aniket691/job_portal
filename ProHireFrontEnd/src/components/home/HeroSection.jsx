import React from 'react'
import { Button } from '../ui/button'
import { Search } from 'lucide-react'
import "./HeroSection.css"; // Import the custom CSS

function HeroSection() {
    return (
        <div className="text-center">
        <div className="flex flex-col gap-5 my-10">
          <span className="mx-auto px-4 py-2 rounded-full bg-gray-100 text-[#F83002] font-medium animate-bounce">
            No. 1 ProPath Career Network
          </span>
          <h1 className="text-5xl font-bold animate-slide-in">
          Find your dream job now<br />
          </h1>
          <p className="animate-fade-in-delayed">
           5 lakh+ jobs for you to explore
          </p>
        </div>
        <div className="flex w-[40%] shadow-lg border border-gray-200 pl-3 rounded-full items-center gap-4 mx-auto">
          <input
            type="text"
            placeholder="Find your dream jobs"
            className="outline-none border-none w-full"
          />
          <Button className="rounded-r-full bg-[#6A38C2] hover:bg-[#5b30a6]">
            <Search className="w-5 h-5" />
          </Button>
        </div>
      </div>
    )
}

export default HeroSection
