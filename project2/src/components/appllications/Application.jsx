import React from "react";
import NavbarRecruiter from "../shared/NavbarRecruiter";
import ShowAppliedApplications from "./ShowAppliedApplications";
import { Button } from "../ui/button";

function Application() {
  return (
    <div>
      <NavbarRecruiter />
      <div className="max-w-6xl mx-auto my-10">
        <div className="flex item-center justify-between ">
          <input className="w-fit" placeholder="filter by name"></input>
        </div>
        <ShowAppliedApplications />
      </div>
    </div>
  );
}

export default Application;
