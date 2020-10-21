<template>
    <div>
        <h1>Buscar</h1>
        <el-form :inline="true">
            <el-form-item>
                <el-input
                    placeholder="Type something"
                    prefix-icon="el-icon-search"
                    >
                </el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary">Query</el-button>
            </el-form-item>
        </el-form>
        <el-divider></el-divider>
    </div>
</template>