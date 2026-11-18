
function Navbar() {

    return (
        <nav className = "m-5 p-5 flex justify-center items-center content-center border-1 border-black text-lg rounded-4xl">
            <ul className="flex gap-5">
                <li>
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#">Products</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
                <li>
                    <a href="#">Login</a>
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