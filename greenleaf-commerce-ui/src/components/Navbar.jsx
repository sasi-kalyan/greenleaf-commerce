
import { Link } from "react-router-dom";

function Navbar() {

    return (
        <nav className = "fixed bg-gl-nav self-center w-full flex p-6 justify-center text-md font-semibold">
            <ul className="flex gap-5">
                <li>
                    <Link to="/">Home</Link>
                </li>
                <li>
                    <a href="#">Products</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
                <li>
                    <Link to="/login">Login</Link>
                </li>
                <li>
                    <a href="#">Signup</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </nav>
    )
}
export default Navbar;