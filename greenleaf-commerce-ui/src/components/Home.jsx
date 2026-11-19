
function Home() {
    
    return (
        <div className="flex flex-col mt-10 min-h-screen justify-center items-center">
            <h1 className="text-3xl font-bold">Welcome to Greenleaf Commerce</h1>
            <p className="text-lg mt-4">Your one-stop solution for all your shopping needs.</p>
            <div className="flex">
                <ul className="mt-5 flex flex-wrap gap-4 justify-center">
                    <li><img src="src/assets/pi.png" alt="Description" className="w-3xs rounded-xl" /></li>
                    <li><img src="src/assets/pi.png" alt="Description" className="w-3xs rounded-xl" /></li>
                    <li><img src="src/assets/pi.png" alt="Description" className="w-3xs rounded-xl" /></li>
                    <li><img src="src/assets/pi.png" alt="Description" className="w-3xs rounded-xl" /></li>
                    <li><img src="src/assets/pi.png" alt="Description" className="w-3xs rounded-xl" /></li>
                </ul>
            </div>
            <div className="mt-10 mb-10 flex justify-center">
                <ul className="flex gap-4 text-md">
                    <li className="bg-gl-nav px-4 py-2 rounded-xl"><a href="#">Login</a></li>
                    <li className="bg-gl-nav px-4 py-2 rounded-xl"><a href="#">Signup</a></li>
                </ul>
            </div>
        </div>
    );
}

export default Home;