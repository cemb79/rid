<template>
    <nav class="bg-primary">
        <div class="max-w-full mx-auto px-2 sm:px-6 lg:px-8">
            <div class="relative flex items-center justify-between h-20">
                <div class="absolute inset-y-0 left-0 flex items-center md:hidden">
                    <!-- Mobile menu button-->
                    <button @click="isExpand = !isExpand" class="inline-flex items-center justify-center p-2 rounded-md text-gray-400 hover:text-white hover:bg-gray-700 focus:outline-none focus:bg-gray-700 focus:text-white transition duration-150 ease-in-out">
                        <svg v-if="!isExpand" class="block h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
                        </svg>
                        <svg v-else class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </button>
                </div>
            
                <div class="flex-1 flex items-center justify-center sm:items-stretch sm:justify-start">
                    <div class="flex flex-shrink-0 items-center">
                        <img class="sm:block lg:hidden h-12 w-auto" src="../assets/Acolcex-white.png" alt="Acolcex logo">
                        <img class="hidden lg:block h-12 w-56" src="../assets/Acolcex-full.png" alt="Acolcex logo">
                    </div>
                    <div class="hidden lg:block sm:ml-6">
                        <div class="flex space-x-4">
                            <router-link :to="{name: 'Home'}" class="px-4 py-4 rounded-md font-medium leading-5 text-secondary bg-blue-800 no-underline hover:no-underline focus:no-underline focus:outline-none focus:text-white focus:bg-gray-700 transition duration-150 ease-in-out"
                                active-class="active">
                                Inicio
                            </router-link>
                            <!--<router-link :to="{name: 'SearchDO'}" class="ml-5 px-4 py-4 rounded-md font-medium leading-5 text-secondary no-underline hover:no-underline hover:text-white hover:bg-gray-700 focus:no-underline focus:outline-none focus:text-white focus:bg-gray-700 transition duration-150 ease-in-out">Buscar</router-link>
                            <router-link :to="{name: 'ReportHome'}" class="ml-5 px-4 py-4 rounded-md font-medium leading-5 text-secondary no-underline hover:no-underline hover:text-white hover:bg-gray-700 focus:no-underline focus:outline-none focus:text-white focus:bg-gray-700 transition duration-150 ease-in-out">Reportes</router-link> -->
                        </div>
                    </div>
                </div>

                <div class="absolute inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">
                    <button class="p-1 border-2 border-transparent text-gray-400 rounded-full hover:text-white focus:outline-none focus:text-white focus:bg-gray-700 transition duration-150 ease-in-out">
                        <!-- Heroicon name: bell -->
                        <svg class="h-10 w-10" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9" />
                        </svg>
                    </button>

                    <!-- Profile dropdown -->
                    <div class="ml-3 relative">
                        <div>
                            <button @click="showProfile = !showProfile" class="p-1 border-2 border-transparent text-gray-400 rounded-full hover:text-white focus:outline-none focus:text-white focus:bg-gray-700 transition duration-150 ease-in-out" id="user-menu" aria-label="User menu" aria-haspopup="true">
                                <svg class="h-10 w-10" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg>
                            </button>
                        </div>
                        <!--
                            Profile dropdown panel, show/hide based on dropdown state.

                            Entering: "transition ease-out duration-100"
                            From: "transform opacity-0 scale-95"
                            To: "transform opacity-100 scale-100"
                            Leaving: "transition ease-in duration-75"
                            From: "transform opacity-100 scale-100"
                            To: "transform opacity-0 scale-95"
                        -->
                        <div v-if="showProfile" class="origin-top-right absolute right-0 my-3 w-56 rounded-md shadow-lg">
                            <div class="py-1 rounded-md bg-white shadow-xs" role="menu" >
                                <button class="w-full block px-4 py-2 leading-5 text-gray-700 no-underline hover:no-underline hover:bg-gray-100 focus:no-underline focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out" role="menuitem">{{username}}</button>
                                <button @click="logout" class="w-full block px-4 py-2 leading-5 text-gray-700 no-underline hover:no-underline hover:bg-gray-100 focus:no-underline focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out" role="menuitem">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--
            Mobile menu, toggle classes based on menu state.

            Menu open: "block", Menu closed: "hidden"
        -->
        <div v-if="isExpand" class="md:hidden">
            <div class="px-2 pt-2 pb-3">
                <router-link :to="{name: 'Home'}" class="block px-3 py-2 rounded-md text-base font-medium text-white bg-gray-900 focus:outline-none focus:text-white focus:bg-gray-700 transition duration-150 ease-in-out">Inicio</router-link>
                <router-link :to="{name: 'SearchDO'}" class="block px-3 py-2 rounded-md text-base font-medium text-white bg-gray-900 focus:outline-none focus:text-white focus:bg-gray-700 transition duration-150 ease-in-out">Buscar</router-link>
                <router-link :to="{name: 'ReportHome'}" class="block px-3 py-2 rounded-md text-base font-medium text-white bg-gray-900 focus:outline-none focus:text-white focus:bg-gray-700 transition duration-150 ease-in-out">Reportes</router-link>
            </div>
        </div>
    </nav>

</template>

<script>
    export default {
        data() {
            return {
                isExpand: false,
                showProfile: false
            }
        },
        methods: {
            logout() {
                this.$store.dispatch('logout')
            }
        },
        computed: {
            username() {
                return this.$store.state.userId
            }
        }
    }
</script>