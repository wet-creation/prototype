package com.misha.prototype

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun Home() {
    ListTabs("Currency")
}

@Preview(showSystemUi = true)
@Composable
fun Search() {
    Column {
        Row {
            MySearchBar()
        }
        Row {
            CurrencyList(text = "Curr")
        }
    }


}

@Composable
fun Favorite() {
    ListTabs("Fav Curr")
}

@Composable
fun CurrencyList(text: String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 15.dp)

    ) {
            for (i in 0..30)
                Row(
                    modifier = Modifier.padding(vertical = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.weight(2.5f),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "CurIcon",
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                        Text(
                            text = "$text $i",
                            fontSize = 20.sp
                        )
                    }
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "${Random.nextInt(1, 100)}.${Random.nextInt(0, 99)}",
                            fontSize = 20.sp,
                        )
                    }
                }
        }
    }


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListTabs(text: String){
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Fiat", "Crypto")
    val pagerState = rememberPagerState {
        tabTitles.size
    }
    LaunchedEffect(selectedTabIndex){
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage){
        selectedTabIndex = pagerState.currentPage
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabTitles.forEachIndexed{ index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item)
                    }
                )
            }
        }
        
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {index ->
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CurrencyList(text = "${tabTitles[index]} $text")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySearchBar() {
    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

    SearchBar(
        query = text,
        onQueryChange ={
            text = it
        },
        onSearch ={
            active = false
        },
        active = active,
        onActiveChange ={
            active = false
        },
        placeholder = {
            Text("Search")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "BarSearch"
            )
        }
    ) {
    }
}