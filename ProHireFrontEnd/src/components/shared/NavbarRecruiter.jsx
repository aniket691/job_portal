import React from "react";
import { Avatar, AvatarFallback, AvatarImage } from "@radix-ui/react-avatar";
import {
  Popover,
  PopoverContent,
  PopoverTrigger,
} from "@radix-ui/react-popover";
import { LogOut, User2 } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Link, useNavigate } from "react-router-dom";

const NavbarRecruiter = () => {
  const navigate = useNavigate();
  const isLoggedIn = Boolean(sessionStorage.getItem("recruiter"));
  

  const handleLogout = () => {
    sessionStorage.clear();
    navigate("/loginrecruiter");
  };

  return (
    <div className="bg-sky-950 shadow-lg">
      <div className="flex items-center justify-between mx-auto max-w-7xl h-16">
        <div>
        <div className="relative group">
            <h1 className="text-2xl font-bold text-white transition-transform duration-300 ease-in-out group-hover:translate-y-[-4px]">
              PRO<span className="text-[#F83002]">HIRE</span>
            </h1>
            <span className="absolute inset-0 opacity-0 group-hover:opacity-30 transition-opacity duration-300 ease-in-out"></span>
          </div>
        </div>
        <div className="flex items-center gap-5">
          <ul className="flex font-medium items-center gap-5">
          <li className="relative group">
              <Link
                to="/"
                className="hover:text-[#F83002] transition-colors duration-200 text-white"
              >
                Home
                <span className="absolute left-0 bottom-[-3px] w-full h-[2px] bg-[#F83002] scale-x-0 group-hover:scale-x-100 transition-transform origin-left duration-300 ease-in-out"></span>
              </Link>
            </li>
            <li className="relative group">
              <Link
                to="/recruiter/application"
                className="hover:text-[#F83002] transition-colors duration-200 text-white"
              >
                Show Applications
                <span className="absolute left-0 bottom-[-3px] w-full h-[2px] bg-[#F83002] scale-x-0 group-hover:scale-x-100 transition-transform origin-left duration-300 ease-in-out"></span>
              </Link>
            </li>
            <li className="relative group">
              <Link
                to="/recruiter/companies"
                className="hover:text-[#F83002] transition-colors duration-200 text-white"
              >
                Companies
                <span className="absolute left-0 bottom-[-3px] w-full h-[2px] bg-[#F83002] scale-x-0 group-hover:scale-x-100 transition-transform origin-left duration-300 ease-in-out"></span>
              </Link>
            </li>
          
          </ul>
          {!isLoggedIn ? (
            <div className="flex gap-3">
              <Link to="/loginrecruiter">
                <Button 
                 className="bg-[#fdfdfd] hover:bg-[#0ec949]"
                variant="outline">Login</Button>
              </Link>
              <Link to="/signuprecruiter">
                <Button className="bg-[#02367B] hover:bg-[#006CA5]">
                  SignUp
                </Button>
              </Link>
            </div>
          ) : (
            <Popover>
              <PopoverTrigger asChild>
                <Avatar className="cursor-pointer w-8 h-8 rounded-full"> {/* Added rounded-full here */}
                  <AvatarImage
                    src="https://github.com/shadcn.png"
                    alt="@shadcn"
                  />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>
              </PopoverTrigger>
              <PopoverContent className="p-4 bg-sky-950 text-white rounded-lg">
                <div className="mb-4">
                  <h4 className="font-medium">Patel MernStack</h4>
                  <p className="text-sm text-muted-foreground p-4 bg-sky-950 text-white rounded-lg">
                    Lorem ipsum dolor sit amet
                  </p>
                </div>
                <div className="flex flex-col gap-3 text-gray-600">
                  <div className="flex w-fit items-center gap-2 cursor-pointer">
                    <LogOut />
                    <Button 
                    className="p-4 bg-sky-950 text-white rounded-lg"
                    variant="link" onClick={handleLogout}>
                      Logout
                    </Button>
                  </div>
                </div>
              </PopoverContent>
            </Popover>
          )}
        </div>
      </div>
    </div>
  );
};

export default NavbarRecruiter;
